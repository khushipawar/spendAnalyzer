import React, { useState, useEffect } from "react";
import axios from "axios";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [balance, setBalance] = useState(0);
  const [totalExpenses, setTotalExpenses] = useState(0);
  const [totalIncome, setTotalIncome] = useState(0);
  const [account, setAccount] = useState("");
  const [password, setPassword] = useState("");

  useEffect(() => {
    if (isLoggedIn) {
      // Fetch data from API
      axios
        .get(`http://localhost:8080/statistics/${account}`)
        .then((response) => {
          setBalance(response.data.balance);
          setTotalExpenses(response.data.totalExpenses);
          setTotalIncome(response.data.totalIncome);
        })
        .catch((error) => {
          console.error("Failed to fetch data:", error);
        });
    }
  }, [isLoggedIn]);

  const handleAccountChange = (event) => {
    setAccount(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleLogin = () => {
    // Make a POST request to the backend to validate the account and password
    axios
      .post("http://localhost:8080/statistics/login", { account, password })
      .then(() => {
        // Login successful
        setIsLoggedIn(true);
      })
      .catch((error) => {
        // Login failed
        console.error("Login failed:", error);
      });
  };

  const handleLogout = () => {
    setIsLoggedIn(false);
    setBalance(0);
    setTotalExpenses(0);
    setTotalIncome(0);
    setAccount("");
    setPassword("");
  };

  if (!isLoggedIn) {
    return (
      <div>
        <h1>Login</h1>
        <div>
          <label htmlFor="account">Account:</label>
          <input
            type="text"
            id="account"
            value={account}
            onChange={handleAccountChange}
          />
        </div>
        <div>
          <label htmlFor="password">Password:</label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={handlePasswordChange}
          />
        </div>
        <button onClick={handleLogin}>Login</button>
      </div>
    );
  }

  return (
    <div>
      <h1>Welcome to the Dashboard!</h1>
      <div>
        <h2>Balance: {balance}</h2>
        <h3>Total Expenses: {totalExpenses}</h3>
        <h3>Total Income: {totalIncome}</h3>
      </div>
      <button onClick={handleLogout}>Logout</button>
    </div>
  );
}

export default App;
