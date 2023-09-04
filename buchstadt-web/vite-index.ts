import fs from "fs";

function createHtml(title: string, name: string) {
  return `
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0" />
    <link rel="icon" href="/favicon.ico" />
    <title>${title}</title>
  </head>
  <body>
    <div id="app"></div>
    <script type="module" src="src/project/${name}/main.ts"></script>
  </body>
</html>
  `;
}

function createFile(path: string, html: string) {
  fs.writeFile(path, html, err => {});
}

function parseScript(script: string) {
  return script.split(":")[1];
}

export function injectHtml(path: string, script: string, config: { title: string }) {
  const name = parseScript(script);
  const html = createHtml(config.title, name);
  createFile(`${path}index.html`, html);
  return { name, html };
}
