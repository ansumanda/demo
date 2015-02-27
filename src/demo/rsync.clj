(ns demo.rsync
  (:import (java.util.concurrent Executors)))

(def my-balance (ref 1000 ))
(def your-balance (ref 2000 ))

(println @my-balance)
(println @your-balance)

(defn transfer-to-me [] (loop [i 10] (when (> i 0) (dosync (alter my-balance + 50) (alter your-balance  - 50)) (println "my-balance" @my-balance) (println "your-balance" @your-balance) (recur (dec i)))))


(defn transfer-to-you [] (loop [i 10] (when (> i 0) (dosync (alter my-balance - 20) (alter your-balance  + 20)) (println "my-balance" @my-balance) (println "your-balance" @your-balance) (recur (dec i)))))

(def executor (Executors/newFixedThreadPool 20))

(defn transaction [] (loop [i 4] (when (> i 0) (do (.submit executor (proxy [Runnable] [] (run [] (transfer-to-me)))) (.submit executor (proxy [Runnable] [] (run [] (transfer-to-you))))) (recur (dec i)))))

(transaction)
