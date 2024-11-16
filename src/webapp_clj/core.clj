(ns webapp-clj.core
  (:require [compojure.core :refer [defroutes GET POST]]
            [compojure.route :as route]
            [webapp-clj.views :as views]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/"
      []
      (views/home-page))
  (GET "/add-location"
      []
      (views/add-location-page))
  (POST "/add-location"
        {params :params}
    (views/add-location-results-page params))
  (GET "/location/:loc-id"
      [loc-id]
      (views/location-page loc-id))
  (GET "/all-locations"
      []
    (views/all-locations-page))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  ;; use #' prefix for REPL-friendly code -- see note below
  (wrap-defaults #'app-routes site-defaults))

(defn -main []
  (jetty/run-jetty #'app {:port 3000}))

(comment
  ;; evaluate this def form to start teh webapp via the REPL:
  ;; :join? false runs the web server in the background)
  (def server (jetty/run-jetty #'app {:port 3000 :join? false}))
  ;; evaluate this form to stop the webapp via the REPL:
  (.stop server))
