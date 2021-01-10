import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ShopmenuComponent } from './shopmenu/shopmenu.component';
import {FormsModule } from '@angular/forms';
import { ShopsComponent } from './admin/shops/shops.component';
import { AddshopComponent } from './admin/Shops/addshop/addshop.component';
import { AllShopsComponent } from './all-shops/all-shops.component';
import { ProductAddComponent } from './product-add/product-add.component';
import { OnlineProductsComponent } from './online-products/online-products.component';
import { MDBBootstrapModule } from 'angular-bootstrap-md';




@NgModule({
  declarations: [
    AppComponent,
    ShopmenuComponent,
    ShopsComponent,
    AddshopComponent,
    AllShopsComponent,
    ProductAddComponent,
    OnlineProductsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MDBBootstrapModule
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
