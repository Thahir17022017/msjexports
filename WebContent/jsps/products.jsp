<%@page pageEncoding="utf-8" %>
<div class="container">
<br>
<br>
<br>
<br>
<div class="form-group row">
  <div class="col-sm-5 mt-1 p-1">
    <label for="addProd" class="customfont" style="color:white;">Add Product Names * :</label>
    <input class="form-control customfont" id="addProd" type="text" placeholder="Use comma seperator for multiple items">
  </div>
  <div class="col-sm-7 mt-4 p-3">
    <button type="button" class="btn btn-success customfont" onclick="addProducts()">Add Products</button>
  </div>
  <div id="addprodmsg1" class="customfont ml-3" style="visibility:hidden;color:white;opacity:1;">Product Names are Required</div>
</div>

<div class="form-group row">
  <div class="col-sm-5 mt-1 p-1">
    <label for="delProd" class="customfont" style="color:white;">Delete Product Names * : </label>
    <input class="form-control customfont" id="delProd" type="text" placeholder="Use comma seperator for multiple items">
  </div>
  <div class="col-sm-7 mt-4 p-3">
    <button type="button" class="btn btn-success customfont" onclick="delProducts()">Delete Products</button>
  </div>
  <div id="addprodmsg2" class="customfont ml-3" style="visibility:hidden;color:white;opacity:1;">Product Names are Required</div>
</div>

<div class="form-group row">
  <div class="col-sm-5 mt-1 p-1">
    <label for="fromProd" class="customfont" style="color:white;">Update Product Name * : </label>
    <input class="form-control customfont" id="fromProd" type="text" placeholder="From Product">
    <div class="mt-2"><input class="form-control customfont" id="toProd" type="text" placeholder="To Product"></div>
  </div>
  <div class="col-sm-7 mt-4 p-3">
    <button type="button" class="btn btn-success customfont" onclick="updateProductName()">Update Product</button>
  </div>
  <div id="addprodmsg3" class="customfont ml-3" style="visibility:hidden;color:white;opacity:1;"></div>
</div>

</div>








