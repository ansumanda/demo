(ns demo.collections)



;; lists are singly linked lists
(def list1 (list 2 "abc" 8 1.2))
(def vector1 ["v1" 2 5 "v5"])

(println list1)
(println vector1)

(println (count list1))
(println (count vector1))

(println (conj list1 "extra-item"))
(println (conj vector1 "extra-item"))

(println list1)
(println vector1)

(println (get list1 1))
(println (get vector1 1))

; (println (assoc list1 1 "new-item"))
(println (assoc vector1 1 'new-item))

(println (rest list1))
(println (rest vector1))

; (println (contains? list1 2))
(println (contains? vector1 2))


(println (some integer? [1 2 3 4 5]))
(println (some (fn [arg] (if (string? arg) arg false)) [1 2 3 "a string" 5]))
(println (every? integer? [1 "string" 3 4 5]))
(println (every? integer? [1 2 3 4 5]))


(println (map (fn [x] (+ x 1)) (list 1 2 3 4)))
(println (reduce (fn [arg1 arg2] (if (> arg1 arg2) arg1 arg2)) [3 1 5 7 3 6]))
