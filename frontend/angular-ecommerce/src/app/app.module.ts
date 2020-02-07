import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ProductListComponent } from './components/product-list/product-list.component'; // import for productListComponent
import { HttpClientModule } from '@angular/common/http';  //import for httpModule, to access web
import { ProductService } from './services/product.service';

import { Routes, RouterModule } from '@angular/router'; //import for routing

// DEFINE ROUTING
const routes: Routes = [
  { path: 'category/:id', component: ProductListComponent },
  { path: 'category', component: ProductListComponent },
  { path: 'products', component: ProductListComponent },
  { path: '', redirectTo: '/products', pathMatch: 'full' },
  { path: '**', redirectTo: '/products', pathMatch: 'full' },
];

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent
  ],
  imports: [
    RouterModule.forRoot(routes), //turn routing on
    BrowserModule,
    HttpClientModule,
  ],
  providers: [ProductService], //add here service
  bootstrap: [AppComponent] //add bootsrtrap
})
export class AppModule { }
