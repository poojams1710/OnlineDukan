import { Component } from '@angular/core';
import { CartItem } from './common/cart-item';
import { Item } from './common/item';
import { TokenStorageService } from './services/token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl:'./app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-onlineshopping';
  private roles: string[];
  isLoggedIn = true;
  showAdminBoard = false;
  showCart=false;
  name:string;

  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit() {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showCart = this.roles.includes('ROLE_USER');

      this.name = user.firstname;
    }
  }

  logout() {
    this.tokenStorageService.signOut();
    window.location.reload();
  }
}


