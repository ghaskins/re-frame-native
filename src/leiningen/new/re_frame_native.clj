(ns leiningen.new.re-frame-native
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "re-frame-native"))

(defn re-frame-native
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' re-frame-native project.")
    (->files data
             ["src/{{sanitized}}/foo.clj" (render "foo.clj" data)])))