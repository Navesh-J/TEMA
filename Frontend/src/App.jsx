import { BrowserRouter, Routes, Route } from "react-router-dom";

import AdminLogin from "./pages/auth/AdminLogin";
import VendorLogin from "./pages/auth/VendorLogin";
import UserLogin from "./pages/auth/UserLogin";
import UserSignup from "./pages/auth/UserSignup";
import VendorSignup from "./pages/auth/VendorSignup";
import AdminDashboard from "./pages/admin/AdminDashboard";
import VendorDashboard from "./pages/vendor/VendorDashboard";
import UserDashboard from "./pages/user/UserDashboard";
import VendorProductsPage from "./pages/vendor/VendorProductsPage";
import AddItemPage from "./pages/vendor/AddItemPage";
import VendorListPage from "./pages/user/VendorListPage";
import VendorShopPage from "./pages/user/VendorShopPage";
import CartPage from "./pages/user/CartPage";
import CheckoutPage from "./pages/user/CheckoutPage";
import OrderSuccessPage from "./pages/user/OrderSuccessPage";
import GuestListPage from "./pages/user/GuestListPage";
import UserOrdersPage from "./pages/user/UserOrdersPage";
import VendorOrdersPage from "./pages/vendor/VendorOrdersPage";
import UpdateStatusPage from "./pages/vendor/UpdateStatusPage";
import LandingPage from "./pages/LandingPage";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<LandingPage />} />
        <Route path="/admin-login" element={<AdminLogin />} />
        <Route path="/vendor-login" element={<VendorLogin />} />
        <Route path="/user-signup" element={<UserSignup />} />
        <Route path="/vendor-signup" element={<VendorSignup />} />
        <Route path="/admin-dashboard" element={<AdminDashboard />} />
        <Route path="/vendor-dashboard" element={<VendorDashboard />} />
        <Route path="/user-dashboard" element={<UserDashboard />} />
        <Route path="/vendor/products" element={<VendorProductsPage />} />
        <Route path="/vendor/add-item" element={<AddItemPage />} />
        <Route path="/user/vendors/:category" element={<VendorListPage />} />
        <Route path="/user/shop/:vendorId" element={<VendorShopPage />} />
        <Route path="/user/cart" element={<CartPage />} />
        <Route path="/user/checkout" element={<CheckoutPage />} />
        <Route path="/user/order-success" element={<OrderSuccessPage />} />
        <Route path="/user/guests" element={<GuestListPage />} />
        <Route path="/user/orders" element={<UserOrdersPage />} />
        <Route path="/vendor/orders" element={<VendorOrdersPage />} />
        <Route path="/vendor/update-status/:orderId" element={<UpdateStatusPage />}/>
        <Route path="/user-login" element={<UserLogin />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
