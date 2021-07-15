
class LinkData {
  name: string;
  type: string;
  url: string;
  constructor(json?: any) {
    this.url = "";
    this.name = "";
    this.type = "";
    if (json) {
      this.url = json.url;
      this.name = json.name;
      this.type = json.type;
    }
  }

}

export default LinkData;