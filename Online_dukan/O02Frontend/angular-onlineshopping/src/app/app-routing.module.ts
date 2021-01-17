import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShopsComponent } from './shopcomponents/admin/shops/shops.component';
import { AllShopsComponent } from './shopcomponents/all-shops/all-shops.component';
import { OnlineProductsComponent } from './shopcomponents/online-products/online-products.component';
import { ProductAddComponent } from './shopcomponents/product-add/product-add.component';

const routes: Routes = [
  {path:'',pathMatch:'full',redirectTo:'login'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
