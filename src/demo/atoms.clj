(ns demo.atoms
  (:import (java.util.concurrent Executors)))

(def balance (atom 1000))

(println @balance)

(defn add-balance [] (loop [i 10] (when (> i 0) (swap! balance inc) (println @balance) (recur (dec i)))))
(defn remove-balance [] (loop [i 10] (when (> i 0) (swap! balance dec) (println @balance) (recur (dec i)))))

(def executor (Executors/newFixedThreadPool 20))

(defn transaction [] (loop [i 4] (when (> i 0) (do (.submit executor (proxy [Runnable] [] (run [] (add-balance)))) (.submit executor (proxy [Runnable] [] (run [] (remove-balance))))) (recur (dec i)))))

(transaction)

(println "Final value: " @balance)



