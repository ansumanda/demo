(ns demo.macros)

; converts to edn-format (extensible data notation)
(def data (read-string (slurp (clojure.java.io/resource "data.txt"))))

(println data)

(println (eval data))



(def function (read-string (slurp (clojure.java.io/resource "function.txt"))))

(println function)

(println (eval function))


(defmacro postfix-notation [expression] (conj (butlast expression) (last expression)))

(println (postfix-notation (4 5 +)))

(println (macroexpand '(postfix-notation (4 5 +))))