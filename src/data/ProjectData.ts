import LinkData from "./LinkData";

export class ProjectData {
  title: string;
  logo: string;
  type: string;
  status: string;
  year: string;
  description: string;
  tech: string[];
  links: [];

  constructor(json?: any) {
    this.title = "";
    this.logo = "";
    this.type = "";
    this.status = "";
    this.year = "";
    this.description = "";
    this.tech = [];
    this.links = [];
    
    if (json) {
      console.log(json);
      this.title = json.title;
      this.logo = json.logo;
      this.type = json.type;
      this.status = json.status;
      this.year = json.year;
      this.description = json.description;
      this.tech = json.tech.slice(0,12);
      this.links = json.links.slice(0,3).map((link:any) => new LinkData(link));
    }
  }

  getStatusValue = (status:string) => {
    switch (status) {
      case "ACTIVE": return 1;
      case "PRODUCTION": return 2;
      case "ARCHIVED": return 3;
    }
    return 0;
  }

  compare = (project: ProjectData) => {
    return this.getStatusValue(this.status) - this.getStatusValue(project.status);
  }
}

export default ProjectData;