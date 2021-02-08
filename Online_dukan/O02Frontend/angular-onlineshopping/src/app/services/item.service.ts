import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import{ map } from 'rxjs/operators';
import { Item } from '../common/item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {


  private baseUrl =' http://localhost:9090/api/items ';

  constructor(private httpClient: HttpClient) { }

  getItemList(theCategoryId: number): Observable<Item[]>{

    const searchUrl = `${this.baseUrl}`;

    return this.getItems(searchUrl);


  }
  searchItems(theKeyword: string): Observable<Item[]> {
    const searchUrl = `${this.baseUrl}`;


    return this.getItems(searchUrl);
  }


  private getItems(baseUrl: string): Observable<Item[]> {
    return this.httpClient.get<GetResponse>(baseUrl).pipe(
      map(response => response._embedded.items)
    );
  }
}
interface GetResponse{
  _embedded:{
    items: Item[];
  }

}
