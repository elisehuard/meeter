(ns meeter.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.form-helpers :only [form-to text-field submit-button]]
        [hiccup.page-helpers :only [html5 include-css include-js]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "meeter"]
               (include-css "/css/reset.css")
               (include-css "/css/application.css")
               (include-js "/js/jquery-1.7.2.min.js")
               (include-js "/js/meeter.js")]
              [:body
               [:div#wrapper
                content]]))

(defpartial start []
            [:h1 "Meeter"]
            [:p "Make your time count"]
            (form-to [:post "/new"]
                     [:fieldset
                       [:label {:for "number"} "Number"]
                       (text-field "number")]
                     [:fieldset
                       [:label {:for "time"} "time"]
                       [:select {:id "time"}
                         [:option {:value "15"} "15 minutes"]
                         [:option {:value "20"} "20 minutes"]
                         [:option {:value "25"} "25 minutes"]
                         [:option {:value "30"} "30 minutes"]]]
                     [:fieldset (submit-button "proceed")]))
