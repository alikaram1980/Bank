var app=angular.module("myBankApp",[]);
app.controller("myBankConroller",function($scope,$http){
	
	$scope.account=null;
	$scope.accountCode=null;
	$scope.operation={type:"payment",amount:0}
	$scope.pageOperations=[];
	$scope.pageCurrent=0;
	$scope.pageSize=3;
	$scope.pages=[];
	
	
	$scope.loadAccount=function(){
		$scope.pageCurrent=0;
		$http.get("/accounts/"+$scope.accountCode)
		.success(function(data){
			console.log(data);
			$scope.account = data;
			$scope.loadOperations();
		});
	};
	
	$scope.loadOperations=function(){
		
		$http.get("/operations?codeAccount="+$scope.accountCode
				+"&page="+$scope.pageCurrent
				+"&size="+$scope.pageSize)
		.success(function(data){
			console.log(data);
			$scope.pageOperations=data;
			$scope.pages=new Array(data.totalPages)
		
		});
	};
	
	$scope.goToPage=function(p){
		$scope.pageCurrent=p;
		$scope.loadOperations();
		
		
	};
	
	
	$scope.saveOperation=function(){
		
		$http({
			
			method : 'put',
			url    :$scope.operation.type,
			data   :"code="+$scope.accountCode+"&amount="+$scope.operation.amount+"&codeEmp=1",
			headers :{'Content-Type': 'application/x-www-form-urlencoded'}
		})
		
		.success(function(data){
			
			$scope.loadAccount();
			//$scope.loadOperations();
		});
		
		
		
		
		
	};
});