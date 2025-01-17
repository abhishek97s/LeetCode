<p align="center">
  <a href="https://walkccc.github.io/LeetCode/"><img src="https://i.imgur.com/mDXzzNp.png" width="300" title="LeetCode" alt="LeetCode"></a>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/-1425/2127%20=%2067.0%25%20Solved-blue.svg?style=flat-square" />
  <img src="https://img.shields.io/badge/-Easy%20319-5CB85D.svg?style=flat-square" />
  <img src="https://img.shields.io/badge/-Medium%20790-F0AE4E.svg?style=flat-square" />
  <img src="https://img.shields.io/badge/-Hard%20316-D95450.svg?style=flat-square" />
</p>

# LeetCode Solutions

## Getting Started

In this repository, I'll work on solutions to [LeetCode](https://leetcode.com/problemset/all/) problems by C++, Java, and Python as much as I could.

Also, I build a website by [GitHub Actions](https://github.com/features/actions) to host the code files by markdown files.
You can see the built page here: [LeetCode Solutions](https://walkccc.github.io/LeetCode/).

## Coding Style

> I believe messy code is costing you.
>
> Therefore, I follow the formatter 99% of the time, but in rare situations, I format the code manually because it might look better in these cases.

- **C++** code is formatted by [clang-format](https://clang.llvm.org/docs/ClangFormat.html) following the [Google C++ Style Guide](https://google.github.io/styleguide/cppguide.html#Spaces_vs._Tabs). You can see the configuration [here](https://github.com/google/leveldb/blob/master/.clang-format).
- **Java** code is formatted by [clang-format](https://clang.llvm.org/docs/ClangFormat.html) following the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html).
- **Python** code is formatted by [PEP 8 -- Style Guide for Python Code](https://www.python.org/dev/peps/pep-0008/) except passing the argument `--indent-size=2` for a better viewing experience in mobile devices.

Take a look at my nvim configuration related to auto formatting.

In `~/.config/nvim/init.lua`:

```lua
function sourceLuaFiles(dirname)
  local p = io.popen('ls ' .. dirname .. '| grep .lua')
  for filename in p:lines() do
    require(filename:sub(1, -5))
  end
end

sourceLuaFiles('~/.config/nvim/lua')
```

In `~/.config/nvim/lua/plugins.lua`:

```lua
-- Autocommand that formats on save
vim.cmd [[
  augroup autoformat_settings
    autocmd!
    autocmd FileType c,cpp,java AutoFormatBuffer clang-format
    autocmd FileType python AutoFormatBuffer autopep8
  augroup END
]]

-- Use packer plugin
local status_ok, packer = pcall(require, 'packer')
if not status_ok then return end

-- Install your plugins here
return packer.startup(function(use)
  -- google/vim-codefmt
  use 'google/vim-maktaba'
  use 'google/vim-codefmt'
  use 'google/vim-glaive'
end)
```

## More Information

The repository is still under construction, and the goal is to keep up with the growth of LeetCode problems by the end of the year!

For more information, please visit my [**GitHub**](https://github.com/walkccc/).

Hosted the site on Feb 23, 2019.

Revised on Dec 25, 2019.

Added `init.vim` on Jan 18, 2021.

Updated to `init.lua` on Jan 1, 2022.
