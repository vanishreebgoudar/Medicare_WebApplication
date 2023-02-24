import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminAddProductComponent } from './admin-add-product/admin-add-product.component';
import { AdminAuthComponent } from './admin-auth/admin-auth.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AdminUpdateProductComponent } from './admin-update-product/admin-update-product.component';
import { HomeComponent } from './home/home.component';
import { AuthGuard } from './auth.guard';
import { UserSearchComponent } from './user-search/user-search.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { UserAuthComponent } from './user-auth/user-auth.component';
import { CartPageComponent } from './cart-page/cart-page.component';
import { CheckoutComponent } from './checkout/checkout.component';

const routes: Routes = [
  {
    path:'',
    component:HomeComponent
  },
  {
    path:'admin-auth',
    component:AdminAuthComponent
  },
  {
    path:'user-auth',
    component:UserAuthComponent
  },
  {
    path:'search/:query',
    component:UserSearchComponent
  },
  {
    component:CartPageComponent,
    path:'cart-page'
  },
  {
    component:CheckoutComponent,
    path:'checkout'
  },
  {
    path:'details/:id',
    component:ProductDetailsComponent
  },
  {
    path:'admin-home',
    component:AdminHomeComponent,
    canActivate:[AuthGuard]
  },
  {
    path:'admin-add-product',
    component:AdminAddProductComponent,
    canActivate:[AuthGuard]
  },
  {
    path:'admin-update-product/:id',
    component:AdminUpdateProductComponent,
    canActivate:[AuthGuard]
  }




];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
