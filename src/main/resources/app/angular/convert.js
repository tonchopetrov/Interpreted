(function(){
    var app = angular.module("interpreterApp",[]);

    var convertService = function($http){

        //var getCompany = function(){
        //    return $http.get("action/add")
        //        .then(function(responce){
        //            return responce.data;
        //        });
        //};

        //http://localhost:3000/localhost:8080/decimalToBinary"
//        var decimalToBinary = function(){
//            return $http.get("http://localhost:8080/decimalToBinary")
//                .then(function(responce){
//                    return responce.data;
//                });
//        };
//
//
//        return{
//            decimalToBinary : decimalToBinary()
//        };
    };

    var interpreterController = function($scope,$http){

//        var success = function(data){
//            console.log("decimalToBinary: "+data);
//            $scope.output = data[1].result;
//        };
//
//
//        var error = function(){
//            $scope.error = 'Error!!';
//            console.log(arguments);
//        };



        $scope.convert = function() {

            var data = {
                    inputItem : $scope.inputItem,
                    outputItem : $scope.outputItem,
                    input : $scope.input,
                    output : $scope.output
            };

            if($scope.inputItem == "Decimal" && $scope.outputItem == "Binary"){
                  $http.post("http://localhost:8080/decimalToBinary", data)
                               .then(
                                   function(response){
                                     $scope.output = response.data;
                                   },
                                   function(response){
                                     console.log(arguments);
                                   }
                                );
            }else if($scope.inputItem == "Binary" && $scope.outputItem == "Decimal"){
                           $http.post("http://localhost:8080/binaryToDecimal", data)
                                        .then(
                                            function(response){
                                              $scope.output = response.data;
                                            },
                                            function(response){
                                              console.log(arguments);
                                            }
                                         );
             }else if($scope.inputItem == "Binary" && $scope.outputItem == "String"){
                         $http.post("http://localhost:8080/binaryToString", data)
                                      .then(
                                          function(response){
                                            $scope.output = response.data.output;
                                          },
                                          function(response){
                                            console.log(arguments);
                                          }
                                       );
             }else if($scope.inputItem == "String" && $scope.outputItem == "Binary"){
                         $http.post("http://localhost:8080/stringToBinary",data)
                                      .then(
                                          function(response){
                                            $scope.output = response.data.output;
                                          },
                                          function(response){
                                            console.log(arguments);
                                          }
                                       );
             }else if($scope.inputItem == "Decimal" && $scope.outputItem == "Hexadecimal"){
                       $http.post("http://localhost:8080/decimalToHexadecimal",data)
                                    .then(
                                        function(response){
                                          $scope.output = response.data.output;
                                        },
                                        function(response){
                                          console.log(arguments);
                                        }
                                     );
             }

        };


    };

    app.controller("interpreterController",interpreterController);
//    app.service("convertService",convertService);
    //app.config(['$httpProvider', function ($httpProvider) {
    //    $httpProvider.defaults.headers.get['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8';
    //}]);

}());