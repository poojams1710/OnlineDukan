import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ItemListComponent } from './components/item-list/item-list.component';
import { HttpClientModule } from '@angular/common/http';
import { ItemService } from './services/item.service';
import {SearchComponent} from './components/search/search.component';

import { Routes, RouterModule} from '@angular/router';
import { CartStatusComponent } from './components/cart-status/cart-status.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './components/login/login.component';
import { UserComponent } from './components/user/user.component';
import { HomeComponent } from './components/home/home.component';
import { AdminComponent } from './components/admin/admin.component';
import { RegisterComponent } from './components/register/register.component';
import { ProfileComponent } from './components/profile/profile.component';
import { OrdersummaryComponent } from './components/ordersummary/ordersummary.component';



import { ShopmenuComponent } from './shopcomponents/shopmenu/shopmenu.component';
import { ShopsComponent } from './shopcomponents/admin/shops/shops.component';
import { AddshopComponent } from './shopcomponents/admin/Shops/addshop/addshop.component';
import { AllShopsComponent } from './shopcomponents/all-shops/all-shops.component';
import { ProductAddComponent } from './shopcomponents/product-add/product-add.component';
import { OnlineProductsComponent } from './shopcomponents/online-products/online-products.component';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { authInterceptorProviders } from './_helper/auth.interceptor';

const routes: Routes =[
  {path: 'login', component: LoginComponent },
  { path: 'user', component: UserComponent },
  { path: 'home', component: HomeComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'admin', component: AdminComponent },
  {path: 'checkout', component: CheckoutComponent},
  {path: 'cart-details', component: CartDetailsComponent},
  {path: 'search/:keyword', component: ItemListComponent},
  {path: 'category/:id', component: ItemListComponent},
  {path: 'category', component: ItemListComponent},
  {path: 'items', component: ItemListComponent},
  {path: 'ordersummary', component: OrdersummaryComponent},
  {path:'',pathMatch:'full',redirectTo:'login'},
  {path :'admin/shops' ,component :ShopsComponent},
  {path :'shops',component :AllShopsComponent},
  {path :'addProducts',component : ProductAddComponent},
  {path :'Products',component:OnlineProductsComponent}

];


@NgModule({
  declarations: [
    AppComponent,
    ItemListComponent,
    SearchComponent,
    CartStatusComponent,
    CartDetailsComponent,
    CheckoutComponent,
    LoginComponent,
    UserComponent,
    HomeComponent,
    AdminComponent,
    RegisterComponent,
    ProfileComponent,





    ShopmenuComponent,
    ShopsComponent,
    AddshopComponent,
    AllShopsComponent,
    ProductAddComponent,
    OnlineProductsComponent,



  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MDBBootstrapModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
