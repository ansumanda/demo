(ns demo.future)
(require 'demo.looping)


(def result (future (demo.looping/fact-tail-recur 30000)))

(println "i am yet to deref future")
(println @result)
(println "i am done derefing future")