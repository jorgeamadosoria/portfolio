import React from "react";
import "./Links.css";
import {
  Github,
  Google,
  Heroku,
  Html5,
  Medium,
} from "@icons-pack/react-simple-icons";

type Props = {
  links: [];
};

const getIcon = (name: string) => {
  switch (name) {
    case "heroku":
      return <Heroku color="#430098" />;
    case "github":
      return <Github color="#181717" />;
    case "html":
      return <Html5 color="#E34F26" />;
    case "medium":
      return <Medium color="#000000" />;
    case "google":
      return <Google color="#4285F4" />;
    default:
      return <></>;
  }
};

const Links = (props: Props) => {
  var { links } = props;
  return (
    <div className="text-middle pt-2">
      {links.map((link: any, index: number) => (
        <div key={index} className="d-inline pe-2 ps-2">
          <a href={link.url} className="text-decoration-none text-dark">
            {getIcon(link.type)}&nbsp;{link.name}
          </a>
        </div>
      ))}
    </div>
  );
};

export default Links;
