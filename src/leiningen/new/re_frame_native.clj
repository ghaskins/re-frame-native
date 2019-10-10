(ns leiningen.new.re-frame-native
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files sanitize]]
            [leiningen.core.main :as main]
            [clojure.java.io :as io]
            [clojure.string :as string]))

(def prj-name "re-frame-native")
(def render (renderer prj-name))

(def template-dir (io/resource (string/join "/" ["leiningen" "new" (sanitize prj-name)])))

(defn re-frame-native
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' re-frame-native project.")
    (->files data
             ["src/{{sanitized}}/foo.clj" (render "foo.clj" data)])))
