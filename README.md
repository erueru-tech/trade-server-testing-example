# trade-server-testing-example

**身の丈を超えた勝負(≒投機)は絶対にやってはいけない**

時系列データを扱うMLアプリケーションの検証用に作った個人の非公開プロジェクトを徐々にこのプロジェクトで公開していく

だったらPythonで実装するべきではという話になるが、最短でアプリケーションを作れるJavaで実装している

当たり前だが責任は負えないのでトレードロジックは一切書かないで、あくまでトレードシステムベースのアプリケーションをテーマにしてサーバサイドのe2eテストの構築方法を説明する

そしてここからは生産速度を半減させるブログを当面書かずに遊び心を持って技術の証明のためだけにやりたいようにやる

## 開発

このプロジェクトではJVM関連のランタイム、ツール、フレームワークのインストールは[SDKMAN](https://sdkman.io/)を使用しています。

公式の[インストール手順](https://sdkman.io/install)
に従い以下のコマンドで環境のセットアップを行ないますが、jenvやopenjdk、Mavenなどを既にHomebrewなど別のパッケージマネージャーでインストール済みの場合は必要に応じて事前にアンインストールを行う必要があります。

```bash
$ curl -s https://get.sdkman.io | bash
$ source "$HOME/.sdkman/bin/sdkman-init.sh"

# 現時点では以下のコマンドでEclipse TemurinのJava21がインストールされる
$ sdk install java
$ java --version

$ sdk install maven
$ mvn --version
```

その他にもこのプロジェクトでは以下のツールを利用しています。

- [pre-commit](https://pre-commit.com/#install) v3.7.0
- [Trivy](https://aquasecurity.github.io/trivy/latest/getting-started/installation/) v0.51.1

各ツールのインストール手順は公式ドキュメントあるいはブログの各ツールの関連[記事](https://zenn.dev/erueru_tech)
を参考にしてください。

## 免責事項

このリポジトリ内のあらゆるソースコードの利用によって不利益を被った場合におきましても、その不利益に関して一切の責任を負いかねます。
