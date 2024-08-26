import { defineConfig } from "eslint-define-config";
import js from "@eslint/js";
import globals from "globals";
import reactHooks from "eslint-plugin-react-hooks";
import reactRefresh from "eslint-plugin-react-refresh";
import tsParser from "@typescript-eslint/parser";
import tsPlugin from "@typescript-eslint/eslint-plugin";
import prettier from "eslint-plugin-prettier";
import prettierConfig from "eslint-config-prettier";

export default defineConfig({
  parser: tsParser,
  parserOptions: {
    ecmaVersion: 2020,
    sourceType: "module",
  },
  plugins: {
    "react-hooks": reactHooks,
    "react-refresh": reactRefresh,
    "@typescript-eslint": tsPlugin,
    prettier: prettier,
  },
  extends: [
    "eslint:recommended",
    "plugin:@typescript-eslint/recommended",
    "plugin:react/recommended",
    "plugin:react-hooks/recommended",
    "plugin:prettier/recommended", // Prettier와의 통합
    "prettier/@typescript-eslint", // TypeScript와의 통합
    "prettier/react", // React와의 통합
    "prettier", // 기본 Prettier 설정
  ],
  rules: {
    "react-refresh/only-export-components": [
      "warn",
      { allowConstantExport: true },
    ],
    "prettier/prettier": [
      "warn",
      {
        singleQuote: true,
        trailingComma: "all",
        semi: true,
        endOfLine: "lf",
      },
    ],
  },
  settings: {
    react: {
      version: "detect",
    },
  },
  ignorePatterns: ["dist"], // Ignored files and directories
  env: {
    browser: true,
    es2021: true,
  },
});
