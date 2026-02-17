import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import api from "../../api/axios";
import UserMenu from "./UserMenu";

function VendorShopPage() {
  const { vendorId } = useParams();

  const [products, setProducts] = useState([]);

  useEffect(() => {
    loadProducts();
  }, []);

  const loadProducts = async () => {
    const res = await api.get(`/api/user/vendors/${vendorId}/products`);

    setProducts(res.data.data);
  };

  const addToCart = async (productId) => {
    await api.post("/api/user/cart/items", {
      productId,
      quantity: 1,
    });

    alert("Added to cart");
  };

  return (
    <div className="min-h-screen bg-gray-100">
      <div className="max-w-6xl mx-auto bg-white p-8 rounded shadow mt-6">
        <UserMenu />

        <h2 className="text-xl font-bold mb-6">Products</h2>

        <div className="grid md:grid-cols-3 gap-4">
          {products.map((p) => (
            <div key={p.id} className="border p-4 rounded">
              <img
                src={p.imageUrl}
                alt={p.name}
                className="w-full h-32 object-cover mb-3"
              />

              <h3 className="font-semibold">{p.name}</h3>

              <p className="text-gray-700 mb-3">Rs {p.price}</p>

              <button
                onClick={() => addToCart(p.id)}
                className="bg-blue-600 text-white px-4 py-2 rounded"
              >
                Add to Cart
              </button>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default VendorShopPage;
