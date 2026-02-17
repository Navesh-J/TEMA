import { useNavigate } from "react-router-dom";

function VendorMenu() {
  const navigate = useNavigate();

  return (
    <div className="flex gap-2 mb-6">
      <button
        onClick={() => navigate("/vendor/orders")}
        className="bg-orange-500 text-white px-4 py-2 rounded"
      >
        Product Status
      </button>

      <button
        onClick={() => navigate("/vendor/request-item")}
        className="bg-purple-500 text-white px-4 py-2 rounded"
      >
        Request Item
      </button>

      <button
        onClick={() => navigate("/vendor/products")}
        className="bg-blue-500 text-white px-4 py-2 rounded"
      >
        View Product
      </button>
    </div>
  );
}

export default VendorMenu;
