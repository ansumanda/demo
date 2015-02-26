(ns demo.looping)

(defn fact [n] (if (= n 1) n (* n (fact (- n 1)))))
(defn fact-tail-recur [n] (loop [counter n value 1] (if (zero? counter) value (recur (- counter 1) (*' counter value)))))


(println (fact 6))
(println (fact-tail-recur 100000))
