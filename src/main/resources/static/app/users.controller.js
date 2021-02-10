(function () {
    'use strict';

    angular.module('app').controller('UsersController', UsersController);

    UsersController.$inject = ['$http'];

    function UsersController($http) {
        let vm = this;
        vm.users = [];

        showAll();

        vm.showAll = showAll;
        vm.remove = remove;
        vm.add = add;

        function showAll(){
            $http.get("/all").then(function (response) {
                vm.users = response.data;
            });
        }
        function remove(id){
            $http.post("/delete/" + id).then(function (response) {
                vm.users = response.data;
                alert('User deleted successfully');
            });
        }

        function add() {
            let user = {
                name: "Jan",
                surname: "Nowak",
                dateOfBirth: "12.03.1993",
                login: "jan.nowak93"
            }

            $http.post("/add", user).then(function (response) {
                alert('User added to list');
                showAll();
            });
        }
    }
})();