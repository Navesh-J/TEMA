import { useEffect, useState } from "react";
import api from "../../api/axios";
import UserMenu from "./UserMenu";

function GuestListPage() {
  const [guests, setGuests] = useState([]);
  const [form, setForm] = useState({
    guestName: "",
    contact: "",
  });

  const loadGuests = async () => {
    const res = await api.get("/api/user/guests");
    setGuests(res.data.data);
  };

  useEffect(() => {
    loadGuests();
  }, []);

  const addGuest = async () => {
    await api.post("/api/user/guests", form);
    setForm({ guestName: "", contact: "" });
    loadGuests();
  };

  const updateGuest = async (id) => {
    const name = prompt("New name");
    const contact = prompt("New contact");

    await api.put(`/api/user/guests/${id}`, {
      guestName: name,
      contact,
    });

    loadGuests();
  };

  const deleteGuest = async (id) => {
    await api.delete(`/api/user/guests/${id}`);
    loadGuests();
  };

  return (
    <div className="min-h-screen bg-gray-100">
      <div className="max-w-4xl mx-auto bg-white p-8 mt-6 rounded shadow">
        <UserMenu />

        <h2 className="text-xl font-bold mb-4">Guest List</h2>

        <div className="flex gap-2 mb-4">
          <input
            placeholder="Guest Name"
            className="border p-2 flex-1"
            value={form.guestName}
            onChange={(e) => setForm({ ...form, guestName: e.target.value })}
          />

          <input
            placeholder="Contact"
            className="border p-2 flex-1"
            value={form.contact}
            onChange={(e) => setForm({ ...form, contact: e.target.value })}
          />

          <button
            onClick={addGuest}
            className="bg-green-600 text-white px-4 rounded"
          >
            Add
          </button>
        </div>

        <div className="space-y-3">
          {guests.map((g) => (
            <div key={g.id} className="border p-3 rounded flex justify-between">
              <span>
                {g.guestName} - {g.contact}
              </span>

              <div className="flex gap-2">
                <button
                  onClick={() => updateGuest(g.id)}
                  className="bg-blue-500 text-white px-2 rounded"
                >
                  Update
                </button>

                <button
                  onClick={() => deleteGuest(g.id)}
                  className="bg-red-500 text-white px-2 rounded"
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

export default GuestListPage;
