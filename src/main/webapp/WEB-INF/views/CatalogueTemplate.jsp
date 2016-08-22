
<div class="generic-container">

    <div class="panel panel-default">
        
        <div class="panel-heading"><span class="lead">Sky Product Selection Catalogue </span></div>
        
	        <div class="formcontainer">
	            
	            <form ng-submit="fetchSubscriptionData()" name="myForm" class="form-horizontal">
	                
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="file">Customer ID :</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="customerId" value={{customerId}} name="custId" class="username form-control input-sm" placeholder="Enter Customer ID" required ng-minlength="2" />
	                            <div class="has-error" ng-show="myForm.$dirty">
	                                <span ng-show="myForm.uname.$error.required">This is a required field</span>
	                                <span ng-show="myForm.uname.$error.minlength">Minimum length required is 2</span>
	                                <span ng-show="myForm.uname.$invalid">This field is invalid </span>
	                            </div>
	                        </div>
	                        <div class="form-actions">
	                         	<input type="submit"  value="Search" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="file">Location ID :</label>
	                        <div class="col-md-7">
	                            <h5 ng-bind="locationId" class="control-lable"></h5>                      
	                        </div>
	                    </div>
	                </div>
	                
	            </form>
	        </div>
    </div>
    <div class="panel panel-default">
        
        <div class="panel-heading"><span class="lead">Channel Subscriptions</span></div>
        
        <div class="tablecontainer column-left">
            <table class="table table-hover table-border-right">
                <thead>
                    <tr>
                        <th>Sports</th>
                    </tr>
                </thead>
                <tbody>
                    <tr ng-repeat="sp in sportsProducts">
                    	  <td>
                         	<input type="checkbox" name="sports" value="sp.productName" ng-click="addProductToBasket($event, sp)"> 
                         	<span ng-bind="sp.productName" class="left-margin"></span>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="tablecontainer column-center" >
            <table class="table table-hover table-border-right">
                <thead>
                    <tr>
                        <th>News</th>
                    </tr>
                </thead>
                <tbody>
                    <tr ng-repeat="np in newsProducts">
                    	  <td>
                         	<input type="checkbox" name="news" value="np.productName" ng-click="addProductToBasket($event, np)"> 
                         	<span ng-bind="np.productName" class="left-margin"></span>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="tablecontainer column-right" >
            <table class="table">
                <thead>
                    <tr>
                        <th>Basket</th>
                    </tr>
                </thead>
                <tbody>
                    <tr ng-repeat="b in basket">
                    	  <td>
                         	<li> <span ng-bind="b.productName"></span> </li>
                        </td>
                    </tr>
                    
                    <tr>
                    	<td>
                    		<button type="button" ng-click="checkout()" ng-show="showCheckoutButton" class="btn btn-success custom-width floatRight margin-btn">Checkout</button>
                    	</td>
                    </tr>
                </tbody>
            </table>
        </div>
        
        <div class="row"> </div>
        
    </div>
</div>