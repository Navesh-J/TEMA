import { useEffect, useState } from "react";
import api from "../../api/axios";
import Navbar from "../../components/Navbar";
import VendorMenu from "./VendorMenu";
import { useNavigate } from "react-router-dom";

function VendorProductsPage() {
  const navigate = useNavigate();
  const [products, setProducts] = useState([]);

  const loadProducts = async () => {
    const res = await api.get("/api/vendor/products");
    setProducts(res.data.data);
  };

  useEffect(() => {
    loadProducts();
  }, []);

  const deleteProduct = async (id) => {
    await api.delete(`/api/vendor/products/${id}`);
    loadProducts();
  };

  const updatePrice = async (id) => {
    const newPrice = prompt("Enter new price");

    if (!newPrice) return;

    await api.put(`/api/vendor/products/${id}`, {
      price: Number(newPrice),
    });

    loadProducts();
  };

  return (
    <div className="min-h-screen bg-gray-100">
      <Navbar
        title="Welcome Vendor"
        onLogout={() => navigate("/vendor-login")}
      />

      <div className="max-w-5xl mx-auto bg-white p-8 rounded shadow">
        <VendorMenu />

        <h2 className="text-lg font-semibold mb-4">Your Products</h2>

        <div className="grid md:grid-cols-3 gap-4">
          {products.map((p) => (
            <div key={p.id} className="border p-4 rounded">
              <img
                src={p.imageUrl}
                alt={p.name}
                className="w-full h-32 object-cover mb-3"
              />

              <h3 className="font-semibold">{p.name}</h3>
              <p className="text-gray-600 mb-3">Rs {p.price}</p>

              <div className="flex gap-2">
                <button
                  onClick={() => updatePrice(p.id)}
                  className="bg-blue-500 text-white px-3 py-1 rounded"
                >
                  Update
                </button>

                <button
                  onClick={() => deleteProduct(p.id)}
                  className="bg-red-500 text-white px-3 py-1 rounded"
                >
                  Delete
                </button>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default VendorProductsPage;
