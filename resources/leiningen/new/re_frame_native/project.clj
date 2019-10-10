(defproject AwesomeProject "0.1.0-SNAPSHOT"
  :min-lein-version "2.5.3"
  :plugins [[lein-shadow "0.1.6"]]

  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.520"
                  :exclusions [com.google.javascript/closure-compiler-unshaded
                               org.clojure/google-closure-library]]
                 [thheller/shadow-cljs "2.8.61"]
                 [reagent "0.8.1"]
                 [re-frame "0.10.9"]]
  :npm-deps [[react "16.8.6"]
             [react-dom "16.8.6"]
             [react-native "0.61.2"]]

  :shadow-cljs {:nrepl {:port 9000}
                :builds {:app
                         {:target :react-native
                          :init-fn awesome.core/init
                          :output-dir "target"
                          :compiler-options {:infer-externs :auto}
                          :devtools {:autoload true}}}}

  :source-paths ["src"]

  :clean-targets ^{:protect false} ["node_modules" "target" "shadow-cljs.edn" "package.json" "package-lock.json" ".shadow-cljs"]

  :profiles
  {:dev {:dependencies [[binaryage/devtools "0.9.10"]]}
   :prod {}})
