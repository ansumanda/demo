(ns demo.var-helper)

(def ^:dynamic y 20)

(defn printy [] (println y))

(defn printy-let [] (let [y 10] (println y) (printy)))

(defn printy-bind [] (binding [y 5] (println y) (printy)))

(printy)
(printy-let)
(printy)
(printy-bind)
(printy)