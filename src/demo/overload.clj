(ns demo.overload)
(require 'demo.var)

(defn poly ([] (poly "Hello" "Clojure"))
  ([arg1] (poly arg1 "clojure"))
  ([arg1 arg2] (println arg1 arg2)))

(poly)
(poly "Great")
(poly "Great" "Java")
