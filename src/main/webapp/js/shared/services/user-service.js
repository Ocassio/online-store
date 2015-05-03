sharedServices.factory("user", function($http) {
    var service =  {

        /**
         * ------------------------------------------------------------------
         * ---------                Public API                      ---------
         * ------------------------------------------------------------------
         */

        info: null,

        isSignedIn: function() {
            return this.info !== null;
        },

        signIn: function(email, password) {
            var path = "/online-store/rest/auth/signIn";
            var params = {
                email: email,
                password: CryptoJS.SHA256(password).toString()
            };

            var promise = $http.put(path, params).success(function(response) {
                if (response.success) {
                    this.info = response.data;
                }
            }.bind(this));

            return promise;
        },

        signUp: function(email, password, name, surname, address) {
            var path = "/online-store/rest/auth/signUp";
            var params = {
                email: email,
                password: CryptoJS.SHA256(password).toString(),
                name: name,
                surname: surname,
                address: address
            };

            var promise = $http.put(path, params).success(function(response) {
                if (response.success) {
                    this.info = response.data;
                }
            }.bind(this));

            return promise;
        },

        signOut: function() {
            return $http.get("/online-store/rest/auth/signOut").success(function() {
                this.info = null;
            }.bind(this));
        },

        update: function(email, name, surname, address) {
            var path = "/online-store/rest/user/update";
            var params = {
                email: email,
                name: name,
                surname: surname,
                address: address
            };

            var promise = $http.put(path, params).success(function(response) {
                if (response.success) {
                    this.loadCurrent();
                }
            }.bind(this));

            return promise;
        },

        changePassword: function(password, oldPassword) {
            var path = "/online-store/rest/user/changePassword";
            var params = {
                password: password,
                oldPassword: oldPassword
            };

            var promise = $http.put(path, params).success(function(response) {
                if (response.success) {
                    this.loadCurrent();
                }
            }.bind(this));

            return promise;
        },

        /**
         * ------------------------------------------------------------------
         * ---------              Private methods                   ---------
         * ------------------------------------------------------------------
         */

        init: function() {
            return this.loadCurrent();
        },

        loadCurrent: function() {
            return $http.get("/online-store/rest/user/getCurrent").success(this.onCurrentLoaded.bind(this));
        },

        onCurrentLoaded: function(response) {
            if (response) {
                this.info = response;
            }
        }

    };

    service.init();

    return service;
});