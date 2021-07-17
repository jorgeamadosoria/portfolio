import React, { useEffect, useState } from "react";
import "./Footer.css";

const Footer = () => {
  const [updateState, setUpdateState] = useState({
    updated_at: "",
  });
  useEffect(() => {
    fetch("https://api.github.com/repos/jorgeamadosoria/portfolio")
      .then((response) => {
        response.json().then((json) => {
          console.log(json);
          setUpdateState({
            updated_at: json.updated_at,
          });
        });
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  return (
    <nav className="footer d-block text-center navbar text-center navbar-light bg-light">
      <i>
        Last updated on:&nbsp;
        {new Date(updateState.updated_at).toLocaleDateString("en-US")}
      </i>
    </nav>
  );
};

export default Footer;
