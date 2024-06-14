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

## ライセンスおよび免責事項

以下は[gnu.org](https://www.gnu.org/licenses/gpl-faq.ja.html#GPLRequireSourcePostedPublic)より引用した当プロジェクトのライセンスの定義になります。

> GPLでは、あなたが改変した版をリリースすることは要求してはいません。改変を加えて、リリースせずに個人的に使うのはあなたの自由です。これは組織(
企業を含む)でも同様で、ある組織は、改変した版を用意してそれを組織外にリリースすることなく内部的に利用することができます。
>
> しかし、もしあなたが改変された版を何らかの形で公にするならば、GPLはあなたが改変したソースコードをユーザがGPLのもとで入手できるようにすることを要求します。
>
> すなわち、GPLは改変されたプログラムを特定のやり方でリリースする許可を与えていますが、別の形でのリリースは許可していないのです。しかし、リリースするかどうかはあなた次第です。

またこのプロジェクト内のあらゆるソースコードの利用によって不利益を被った場合におきましても、その不利益に関して一切の責任を負いかねます。
