
<div class="generic-container">

    <div class="panel panel-default">
        
        <div class="panel-heading"><span class="lead">Customer</span></div>
        
        <div class="formcontainer">
            
             <div class="row">
                 <div class="form-group col-md-12">
                     <label class="col-md-2 control-lable" for="file">Customer ID : {{customerId}}</label>
                 </div>
             </div>
             
             <div class="row">
                 <div class="form-group col-md-12">
                     <label class="col-md-2 control-lable" for="file">Location ID : {{locationId}}</label>
                 </div>
             </div>
                
        </div>
    </div>
    <div class="panel panel-default">
        
        <div class="panel-heading"><span class="lead">Subscription Confirmation</span></div>
        
        <div class="tablecontainer column-left">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Channels Subscribed</th>
                    </tr>
                </thead>
                <tbody>
                    <tr ng-repeat="b in basket">
                    	  <td>
                          	<span ng-bind="b.productName" class="left-margin"></span>
                         </td>
                    </tr>
                </tbody>
            </table>
        </div>
                
        <div class="row"> </div>
        
    </div>
</div>