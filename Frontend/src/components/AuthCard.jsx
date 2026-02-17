function AuthCard({ title, children }) {
  return (
    <div className="min-h-screen flex items-center justify-center bg-gray-100">
      <div className="bg-white w-96 p-8 rounded shadow">
        <h1 className="text-2xl font-bold text-center mb-6">
          {title}
        </h1>
        {children}
      </div>
    </div>
  );
}

export default AuthCard;
