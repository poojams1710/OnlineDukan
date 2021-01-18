import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShopmenuComponent } from './shopmenu/shopmenu.component';
import {ShopsComponent} from './admin/shops/shops.component';
import {AllShopsComponent} from 'frontend/src/app/all-shops/all-shops.component';
import {ProductAddComponent} from 'frontend/src/app/product-add/product-add.component'
import { ShopProducts } from './model/ShopProducts';
import { OnlineProductsComponent } from './online-products/online-products.component';


const routes: Routes = [
{path :'admin/shops' ,component :ShopsComponent},
{path :'shops',component :AllShopsComponent},
{path :'addProducts',component : ProductAddComponent},
{path :'Products',component:OnlineProductsComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }