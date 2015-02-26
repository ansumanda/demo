(ns demo.var)

(def x 10)

(println x)

(println (var x))

(def ref-x (var x))
(println @ref-x)


