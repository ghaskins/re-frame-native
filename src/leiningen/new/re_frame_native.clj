(ns leiningen.new.re-frame-native
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files sanitize raw-resourcer]]
            [leiningen.core.main :as main]
            [clojure.java.io :as io]
            [clojure.string :as string]
            [me.raynes.fs :as fs]))

(def prj-name "re-frame-native")

(defn normalize [path]
  (.getCanonicalPath path))

(defn find-files
  "For a given 'dir', return a recursive list of all the filenames, relative to that dir"
  [dir]
  (let [parent (str (subs (str dir) 5) "/")]
    (->> (fs/iterate-dir dir)
         (reduce (fn [acc [root dirs files]] (concat acc (map (fn [file] (fs/file root file)) files))) [])
         (map (fn [x] (string/replace (normalize x) parent ""))))))

(def raw-types #{".png" ".jar"})
(defn raw? [x]
  (contains? raw-types (fs/extension x)))

(defn dest-path [path]
  (-> path
      (string/replace "Project" "{{sanitized}}")
      (string/replace "git" ".git")))

(defn render-spec [f files]
  (mapv (fn [file] [(dest-path file) (f file)]) files))

(defn render [data files]
  (render-spec #((renderer prj-name) % data) files))

(defn cp [files]
  (render-spec #((raw-resourcer prj-name) %) files))

(defn re-frame-native
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}
        template-dir (io/resource (string/join "/" ["leiningen" "new" (sanitize prj-name)]))
        files (find-files template-dir)
        templates (remove raw? files)
        raw-files (filter raw? files)]
    (main/info "Generating fresh 'lein new' re-frame-native project.")
    (apply ->files data (concat (render data templates)
                                (cp raw-files)))))
