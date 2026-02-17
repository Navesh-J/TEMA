import { useState } from "react";
import api from "../../api/axios";
import Navbar from "../../components/Navbar";
import VendorMenu from "./VendorMenu";
import { useNavigate } from "react-router-dom";

function AddItemPage() {
  const navigate = useNavigate();

  const [form, setForm] = useState({
    name: "",
    price: "",
    imageUrl: "",
    category: "CATERING",
  });

  const handleAdd = async () => {
    try {
      await api.post("/api/vendor/products", {
        ...form,
        price: Number(form.price),
      });

      alert("Product added");
      navigate("/vendor/products");
    } catch (err) {
      alert(err.response?.data?.message || "Error");
    }
  };

  return (
    <div className="min-h-screen bg-gray-100">
      <Navbar
        title="Welcome Vendor"
        onLogout={() => navigate("/vendor-login")}
      />

      <div className="max-w-4xl mx-auto bg-white p-8 rounded shadow">
        <VendorMenu />

        <h2 className="text-lg font-semibold mb-4">Add Product</h2>

        <input
          placeholder="Product Name"
          className="w-full border p-2 mb-3"
          onChange={(e) => setForm({ ...form, name: e.target.value })}
        />

        <input
          placeholder="Product Price"
          className="w-full border p-2 mb-3"
          onChange={(e) => setForm({ ...form, price: e.target.value })}
        />

        <input
          placeholder="Product Image URL"
          className="w-full border p-2 mb-3"
          onChange={(e) => setForm({ ...form, imageUrl: e.target.value })}
        />

        <select
          className="w-full border p-2 mb-4"
          onChange={(e) => setForm({ ...form, category: e.target.value })}
        >
          <option>CATERING</option>
          <option>FLORIST</option>
          <option>DECORATION</option>
          <option>LIGHTING</option>
        </select>

        <button
          onClick={handleAdd}
          className="bg-green-600 text-white px-4 py-2 rounded"
        >
          Add The Product
        </button>
      </div>
    </div>
  );
}

export default AddItemPage;
