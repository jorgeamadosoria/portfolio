import { faGithub } from "@fortawesome/free-brands-svg-icons";
import { faInfoCircle } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import React from "react";
import "./Header.css";

const Header = () => (
  <nav className="navbar navbar-expand-lg navbar-light bg-light">
    <div className="container-fluid d-flex">
      <h3>Portfolio</h3>
      <button
        className="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarText"
        aria-controls="navbarText"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span className="navbar-toggler-icon"></span>
      </button>
      <div className="w-100"></div>
      <div className="collapse navbar-collapse" id="navbarText">
        <ul className=" navbar-nav me-auto mb-2 mb-lg-0">
          <li className="nav-item">
            <a
              title="repository"
              className="nav-link"
              aria-current="page"
              href="https://github.com/jorgeamadosoria/portfolio"
            >
              <FontAwesomeIcon size={"3x"} icon={faGithub} />
            </a>
          </li>
          <li className="nav-item">
            <a
              title="Résumé"
              className="nav-link"
              href="https://jorgeamadosoria.info"
            >
              <FontAwesomeIcon size={"3x"} icon={faInfoCircle} />
            </a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
);

export default Header;
