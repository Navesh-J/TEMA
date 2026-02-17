import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import api from "../../api/axios";
import UserMenu from "./UserMenu";

function VendorListPage() {
  const { category } = useParams();
  const navigate = useNavigate();

  const [vendors, setVendors] = useState([]);

  useEffect(() => {
    loadVendors();
  }, [category]);

  const loadVendors = async () => {
    const res = await api.get(`/api/user/vendors?category=${category}`);

    setVendors(res.data.data);
  };

  return (
    <div className="min-h-screen bg-gray-100">
      <div className="max-w-6xl mx-auto bg-white p-8 rounded shadow mt-6">
        <UserMenu />

        <h2 className="text-xl font-bold mb-6">Vendor → {category}</h2>

        <div className="grid md:grid-cols-3 gap-4">
          {vendors.map((v) => (
            <div key={v.vendorId} className="border p-4 rounded shadow-sm">
              <h3 className="font-semibold text-lg mb-2">{v.vendorName}</h3>

              <p className="text-gray-600 mb-3">{v.description}</p>

              <button
                onClick={() => navigate(`/user/shop/${v.vendorId}`)}
                className="bg-green-600 text-white px-3 py-2 rounded"
              >
                Shop Item
              </button>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default VendorListPage;
