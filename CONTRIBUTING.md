# How to contribute

TotalFreedomMod aims to be a fully functional all-op server mod which works in
a large range of configurations. In order to be as flexible as possible on the
server-end, we encourage contributing to TotalFreedomMod by making 'pull-requests'
to this repository.

## Getting Started

* Make sure you have a [GitHub account](https://github.com/signup/free)
* If the issue is a bug, submit a ticket for it, assuming one does not already exist.
  * Clearly describe the issue including steps to reproduce it.
  * Make sure you fill in the earliest version that you know has the issue.
* Fork the repository on GitHub

## Making Changes

* Create a topic branch from where you want to base your work.
  * This is usually the master branch.
  * Only target release branches if you are certain your addition must be on that
    branch.
  * To quickly create a topic branch based on master; `git checkout -b contribution`
    Please avoid working directly on the `master` branch.
* Make changes and commit where necessary.
* Check for unnecessary whitespace with `git diff --check` before committing.
* Make sure your commit messages are in line with those which are already made.
* Make sure your changes build (*and work!*).

## Tips on getting your pull request accepted
* Make sure your changes work and compile without difficulty.
* Make sure your change adds something useful, do not add commands to micromanage
  the server. (ie: Shorthands for a collection of commands)
* Features must be in line the general idea of "Total Freedom".
* Changes must be directed towards the main "TotalFreedom" server. Adding names such
  as the name of your own TotalFreedom-like server will get your pull request denied.
* Do not add yourself to the developer list.
* Ensure that you use the correct whitespace-style. That is: 4 spaces as indentation.
* Please make sure your changes are written such as other features would be. Eg: commands
  have their own class and extend TFM_Command.
* Make sure your code is written in the [Allman style](http://en.wikipedia.org/wiki/Indent_style#Allman_style).
* Do not increment the version number.
* If you want to add multiple changes, please make one pull request per change. This
  way, it's easier to accept your changes faster and won't block the other changes if there
  is an issue with a specific line of code.
* Please make sure there are no bugs in your code.
* Please avoid having to add files in the main namespace where possible.
* Make sure all changes work before you commit these, this avoids having multiple
  unnecessary commits.
* Please refrain from using an excessive amount of commits. As few as possible is generally the best.
* Please do not spread your addition over several pull-requests.

## Submitting Changes

* Push your changes to a topic branch in your fork of the repository.
* Submit a pull request to this repository.
  * Explain in detail what each one of your commits changes and point out any big changes.
* Wait as a developer evaluates your changes.

# Additional Resources

* [TotalFreedom information](http://totalfreedom.me)
* [TotalFreedom forums](http://totalfreedom.boards.net)
* [Bug tracker](https://github.com/TotalFreedom/TotalFreedomMod/issues)
* [General GitHub documentation](http://help.github.com/)
* [GitHub pull request documentation](http://help.github.com/send-pull-requests/)
