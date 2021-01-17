import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ItemListComponent } from './components/item-list/item-list.component';
import { HttpClientModule } from '@angular/common/http';
import { ItemService } from './services/item.service';
import {SearchComponent} from './components/search/search.component';

import { Routes, RouterModule} from '@angular/router';

const routes: Routes =[
  {path: 'search/:keyword', component: ItemListComponent},
  {path: 'category/:id', component: ItemListComponent},
  {path: 'category', component: ItemListComponent},
  {path: 'items', component: ItemListComponent},
  {path: '',redirectTo: '/items', pathMatch: 'full'},
  {path: '**', redirectTo: '/items',pathMatch: 'full'}
];


@NgModule({
  declarations: [
    AppComponent,
    ItemListComponent,
    SearchComponent

    
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ItemService],
  bootstrap: [AppComponent]
})
export class AppModule { }
