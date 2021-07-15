import {
  Apache,
  Apachemaven,
  Apachetomcat,
  Bootstrap,
  Chartdotjs,
  CssThree,
  Fontawesome,
  Github,
  Google,
  Googledrive,
  Heroku,
  Hibernate,
  Html5,
  Java,
  Javascript,
  Jenkins,
  Jquery,
  Oracle,
  Postgresql,
  ReactJs,
  Spring,
  Springboot,
  Subversion,
  Typescript,
  Vk,
} from "@icons-pack/react-simple-icons";
import React from "react";
import "./TechContainer.css";

type Props = {
  tech: string[];
};

const techIcons = (tech: string) => {
  switch (tech.toLowerCase()) {
    case "spectre framework": //icon pending
      return <Html5 title={tech} color="#E34F26" size={24} />;
    case "java":
    case "jsp": //icon pending
    case "jsf": //icon pending
      return <Java title={tech} color="#007396" size={24} />;
    case "vanillajs":
    case "javascript":
    case "tippy.js": //icon pending
    case "underscorejs": //icon pending
    case "cytoscape.js": //icon pending
    case "interactjs": //icon pending
      return <Javascript title={tech} color="#F7DF1E" size={24} />;
    case "github":
    case "github pages": //icon pending
      return <Github title={tech} color="#181717" size={24} />;
    case "font awesome":
      return <Fontawesome title={tech} color="#339AF0" size={24} />;
    case "heroku":
      return <Heroku title={tech} color="#430098" size={24} />;
    case "vk":
      return <Vk title={tech} color="#4680C2" size={24} />;
    case "tomcat":
      return <Apachetomcat title={tech} color="#F8DC75" size={24} />;
    case "google drive":
      return <Googledrive title={tech} color="#4285F4" size={24} />;
    case "postgres":
      return <Postgresql title={tech} color="#4169E1" size={24} />;
    case "typescript":
      return <Typescript title={tech} color="#3178C6" size={24} />;
    case "bootstrap":
      return <Bootstrap title={tech} color="#7952B3" size={24} />;
    case "hibernate":
      return <Hibernate title={tech} color="#59666C" size={24} />;
    case "jenkins":
      return <Jenkins title={tech} color="#D24939" size={24} />;
    case "oracle":
      return <Oracle title={tech} color="#F80000" size={24} />;
    case "apache":
    case "apache tiles": //icon pending
      return <Apache title={tech} color="#D22128" size={24} />;
    case "maven":
      return <Apachemaven title={tech} color="#C71A36" size={24} />;
    case "css3":
      return <CssThree title={tech} color="#1572B6" size={24} />;
    case "subversion":
      return <Subversion title={tech} color="#809CC9" size={24} />;
    case "html5":
      return <Html5 title={tech} color="#E34F26" size={24} />;
    case "chart.js":
      return <Chartdotjs title={tech} color="#FF6384" size={24} />;
    case "react.js":
      return <ReactJs title={tech} color="#61DAFB" size={24} />;
    case "jquery":
      return <Jquery title={tech} color="#0769AD" size={24} />;
    case "google sites": //icon pending
    case "google sheets": //icon pending
    case "awesome table": //icon pending
      return <Google title={tech} color="#4285F4" size={24} />;
    case "spring framework":
    case "spring security": //icon pending
    case "spring data": //icon pending
      return <Spring title={tech} color="#6DB33F" size={24} />;
    case "spring boot":
      return <Springboot title={tech} color="#6DB33F" size={24} />;
    default:
      return <>{tech}</>;
  }
};

const TechContainer = (props: Props) => {
  const { tech } = props;
  return (
    <div className="text-end lh-lg">
      {tech.map((t, index) => {
        var key = "tech-" + index;
        return (
          <span key={key} className="tech-icon">
            {techIcons(t)}
          </span>
        );
      })}
    </div>
  );
};

export default TechContainer;
