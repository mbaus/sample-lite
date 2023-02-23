# sample-lite

Repo for testing Bug #5435

Here I will dokument the Steps to show the Error.

For the cli comands I will use aciinema, so you can follw my Steps.

---

cd my-react-lite

docker run --rm --pull=always -p 7471:7471 -v $(pwd):/tmp/jhlite:Z -it -d jhipster/jhipster-lite:latest

cd sample

git remote add origin git@github.com:mbaus/sample-lite.git
git push --force

touch INFO.md
vim INFO.md

git add .
git commit -m 'add a INFO.md File for Infos what todo'
git push

asciinema rec documentation/init_projekt.cast

nvm use --lts
npm --version
java -version
./mvnw --version
node --version

npm i
./mvnw

git add documentation/init_projekt.cast
git commit -m 'add first screencast to schow the initialisation'

git add package-lock.json

git commit -m 'add package-lock.json for better transparence normaly I will put this to .gitignore'
✔ Preparing lint-staged...
✔ Running tasks for staged files...
✔ Applying modifications from tasks...
✔ Cleaning up temporary files...
[main f159930] add package-lock.json for better transparence normaly I will put this to .gitignore
1 file changed, 6865 insertions(+)
create mode 100644 package-lock.json


---

Now I add the first ts file to the reppo and it fails .
Pleas see my screecast add_first_file.cast

you can replay ist with ```asciinema play add_first_file.cast```
If you cannot play it, herre is the Website for it:
https://asciinema.org/

to check in this file I remove the execution Flag from Husky
chmod -x .husky/pre-commit
