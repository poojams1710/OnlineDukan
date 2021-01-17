import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { User } from 'src/app/model/user';
import { Shops } from 'src/app/model/shops';
import { ShopProducts } from 'src/app/model/ShopProducts';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GetUserService {

  message : string ;

  product : Array<ShopProducts>;

  constructor(
    private httpClient :HttpClient
  ) { }

  getUserType()
  {

 return this.httpClient.get<User[]> ('http://localhost:9090/users/get');

  }

  addUser(newUser: User) {
    return this.httpClient.post<User>('http://localhost:9090/users/add', newUser);
  }

  getShops() {

    return this.httpClient.get<Shops[]>('http://localhost:9090/shops/get');
  }

  addshop(newshop: Shops) {
    return this.httpClient.post<Shops>('http://localhost:9090/shops/add', newshop);
  }


  addproduct(product: ShopProducts):Observable<Object> {
    return this.httpClient.post('http://localhost:9090/products/add', product);
  }


  getshopProduct(id :number):Observable<Object>{
    return this.httpClient.get(` http://localhost:9090/products/get/${id} `);
  }


}
